import "./Button.css"
import React from 'react'

const Button = ({id, text, action}) => {

  const handleAction = (e) => {
    action(e);
  }

  return (
    <div>
      <button id={id} onClick={handleAction} >{text}</button> {/*O botao tem um identificra id e um texto para exibir denttro dele e para ativa-lo usamos chamamos a função mencionando ela dedntro do botão  */}
    </div>
  )
}

export default Button
