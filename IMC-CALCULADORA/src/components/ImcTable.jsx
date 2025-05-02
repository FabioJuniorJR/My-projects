import React from 'react'
import Button from './Button'
import './ImcTable.css'

const ImcTable = ({data,imc, info, infoClass, resetCalc}) => {
  return (
  <div id="result-container">
      <p id='imc-number'>Seu imc: <span className={infoClass}>{imc}</span> </p>
      <p id="imc-info">Situação atual: <span className={infoClass}>{info}</span> </p>
      <h3>Confira as classificações</h3>
      <div className='imc-Table'>
        <div className='table-header'>
          <h4>IMC</h4>
          <h4>Classificação</h4>
          <h4>Obesidade</h4>
        </div>
        {data.map((item)=>(//vamos passar um objeto por isso o () e nao {}
        <div className='table-data'
             key={item.info} /*coloque estekey pois ele identifica cada valor como unico e evita duplicações e cada um é unico */>
                <p>{item.classification}</p>
                <p>{item.info}</p>
                <p>{item.obesity}</p>
             </div>
        ))}
      </div>
      <Button id="back-btn" text="Voltar" action={resetCalc}></Button>
    </div>
  )
}

export default ImcTable
