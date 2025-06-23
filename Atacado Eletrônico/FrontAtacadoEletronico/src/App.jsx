// src/App.jsx
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './pages/Login';
import CadastroCliente from './pages/CadastroCliente';
import CadastroProduto from './pages/CadastroProduto';
import PainelAdm from './pages/PainelAdm';
import MainCommerce from './pages/MainCommerce'
import CreateOrderTeste from './pages/CreateOrderTeste';

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/cadastroCliente" element={<CadastroCliente />} />
        <Route path='/cadastroProduto' element={<CadastroProduto/>}/>
        <Route path='/painelAdm' element={<PainelAdm/>}/>
        <Route path='/mainCommerce' element={<MainCommerce/>}/>
        <Route path='/orderForm' element={<CreateOrderTeste/>}/>


      </Routes>
    </Router>
  );
}
