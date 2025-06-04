import React from 'react'
import '../styles/CadastroCliente.css';


const CadastroCliente = () => {
  return (
    <div className='screeen-center'>
    <div className='container'>
      <div className='motivation'>
        <h2 className='seuhardware'>Seu HARDWARE</h2>
        <h2 className='suahistoria'>SUA HISTÓRIA</h2>
        <h1 className='comecarhistoria'>COMEÇE AQUI SUA HISTÓRIA</h1>
        <p className='compre'>COMPRE</p>
        <p className='explore'>EXPLORE</p>
        <p className='sedivirta'>SE DIVIRTA</p>
        <h2 className='façavoce'>FAÇA VOCÊ MESMO !!!</h2>
      </div>
      <div className='login-box'>
        <h2>CADASTRO CLIENTE</h2>
        <form >
            <input type="text" placeholder='CPF/CNPJ' required/>

            <input type="text" placeholder='Nome' required/>

            <input type="email" placeholder='Email' required/>

            <input type="text" placeholder='Telefone' required/>

            <input type="text" placeholder='Cep' required/>

            <input type="password" placeholder='Senha'/>
            <p>Já possui cadastro ? <a href="Login">ENTRAR</a></p>
            <button type='submit'>SALVAR</button>
        </form>
      </div>
    </div>
    </div>
  )
}

export default CadastroCliente
