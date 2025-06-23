import { useState } from 'react';
import CadastroCliente from './CadastroCliente'
import '../styles/Login.css';




const Login = () => {

    const [senha, setSenha] = useState("");
    const [cpfCnpj, setcpfCnpj] = useState("");

    const handleSubmit = (e)=>{
        e.preventDefault();
        console.log(cpfCnpj)
        console.log(senha)
    }


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
        <h2>LOGIN</h2>
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder='CPF/CNPJ' onChange={(e)=>setcpfCnpj(e.target.value)}/>
            <input type="password" placeholder='Senha' onChange={(e)=>setSenha(e.target.value)}/>
            <p>Não possui cadastro ? <a href="CadastroCliente">CADASTRAR</a></p>
            <button type='submit' >SALVAR</button>
        </form>
      </div>
    </div>
    </div>
  )
}

export default Login
