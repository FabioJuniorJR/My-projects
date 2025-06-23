// src/pages/PainelAdm.jsx

import '../styles/PainelAdm.css';
import { useNavigate } from 'react-router-dom';


export default function PainelAdm() {
  const navigate = useNavigate();

  return (
    <div className="page">
      <nav className="navbar">
        <span><strong>ADM COLABORADOR</strong></span>
      </nav>

      <main className="painel">
        <button className="card" onClick={() => navigate('/ConsultarProduto')}>CONSULTAR PRODUTO</button>
        <button className="card" onClick={() => navigate('/CadastroProduto')}>CADASTRAR PRODUTO</button>
        <button className="card" onClick={() => navigate('/ConsultarCliente')}>CONSULTAR CLIENTE</button>
      </main>
    </div>
  );
}
