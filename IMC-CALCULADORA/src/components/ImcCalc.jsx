import { useState } from "react";
import Button from "./Button";
import "./ImcCalc.css"

const ImcCalc = ({calcImc}) => {
  //Aqui controlaremos os valores e operações
  const [height, setHeight] = useState("") //definimo oss hooks de manipulação e alteração de dados
  const [weight, setWeight] = useState("")

  //Vamos limpar o campo
  const clearForm = (e)=>{
    e.preventefault();
    setHeight("")
    setWeight("")
  };

  const validDigits = (text) => {
    return text.replace(/[^0-9,]/g,"")
  };

  const handleHeightChange = (e) => {
    const updatedValue = validDigits(e.target.value)
    setHeight(updatedValue);
  };

  const handleWeightChange = (e) => {
    const updatedValue = validDigits(e.target.value)
    setWeight(updatedValue);
  };

  return (
    <div id='calc-container'>
      <h2>Calculadora de IMC</h2>

      <form action="" id="id-form">
        <div className="form-inputs">
            <div className='form-control'>
                <label htmlFor="height">Altura:</label>
                <input type="text"
                        name='height'
                        id='height'
                        placeholder='Exemplo 1,75'
                        //Mapear muança qwuando o usuario digita
                        onChange={(e)=>handleHeightChange(e)}
                        value={height}
                        />
            </div>
            <div className='form-control'>
                <label htmlFor="weight">Peso:</label>
                <input type="text"
                        name='weight'
                        id='weight'
                        placeholder='Exemplo 70,5'
                        onChange={(e)=>handleWeightChange(e)}
                        value={weight}
                        />
            </div>
        </div>
        
        <div className="action-control">
            <Button id="calc-btn" text="Calcular" action={(e)=>calcImc(e, height, weight)}/>
            <Button id="clear-btn" text="Limpar" action={clearForm}/>
        </div>
      </form>
    </div>
  )
};

export default ImcCalc
