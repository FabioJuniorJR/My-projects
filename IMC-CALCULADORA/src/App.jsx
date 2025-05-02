import { useState } from 'react';
import ImcCalc from './components/ImcCalc';
import ImcTable from './components/ImcTable';
import './App.css';
import {data} from './data/data';



function App() {
  const [imc, setImc] = useState("");
  const [info, setInfo] = useState("");
  const [infoClass, setInfoClass] = useState("");

  const calcImc = (e, height, weight)=>{
    e.preventDefault();
    console.log(height, weight);
    if(!height || !weight) return;

    const weightFloat = +weight.replace(",",".")
    const heightFloat = +height.replace(",",".")

    const imcResult = (weightFloat /(heightFloat*heightFloat)).toFixed(1)
    console.log(imcResult);
    setImc(imcResult);

    data.forEach((item)=>{
      if(imcResult >= item.min && imcResult <= item.max){
        setInfo(item.info)
        setInfoClass(item.infoClass)
      }
    });

    if(!info) return;
    
  };

  const resetCalc = (e) => {
    e.preventDefault();
    setImc("");
    setInfo("");
    setInfoClass("");
  };

  return (
    <div className='container'>
        {! imc ? ( <ImcCalc calcImc={calcImc}/>) : <ImcTable data={data} /*para passar os valores como parametro como pede o arquivo imcTable, faça como esta nessa linha, dentro da chama do arquivo coloque desse jeito {coloque aqui}*/ 
          imc={imc} info={info} infoClass={infoClass} resetCalc={resetCalc}
          />}
    </div>
   
  );
}

export default App
