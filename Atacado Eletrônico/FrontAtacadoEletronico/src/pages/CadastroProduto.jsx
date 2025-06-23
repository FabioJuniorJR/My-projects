// src/pages/CadastroProduto.jsx

import { useState } from 'react';
import '../styles/CadastroProduto.css';

export default function CadastroProduto() {
  const [form, setForm] = useState({
    id: '',
    categoria: '',
    fabricante: '',
    nome: '',
    situacao: '',
    preco: '',
    estoque: '',
    descricao: ''
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Produto cadastrado:", form);
    
  };

  return (
    <div className="page">
      <nav className="navbar">
        <span><strong>ADM COLABORADOR</strong></span>
      </nav>

      <form onSubmit={handleSubmit} className="form-container">
        <h2>DETALHES DO PRODUTO</h2>

        <div className="form-row">
          <input name="id" value={form.id} onChange={handleChange} placeholder="id" />
          <select name="categoria" value={form.categoria} onChange={handleChange}>
            <option value="">Categoria</option>
            <option value="Teclado">Teclado</option>
            <option value="Mouse">Mouse</option>
            <option value="CPU">CPU</option>
            <option value="Placa de Vídeo">Placa de Vídeo</option>
          </select>

          <select name="Fabricante" value={form.categoria} onChange={handleChange}>
            <option value="">Fabricate</option>
            <option value="HyperX">HyperX</option>
            <option value="Redragon">Redragon</option>
            <option value="Razer">Razer</option>
            <option value="Xbox">Xbox</option>
          </select>

        </div>

        <div className="form-row">
          <input name="nome" value={form.nome} onChange={handleChange} placeholder="Name" />
          <select name="categoria" value={form.categoria} onChange={handleChange}>
          <option value="">Situação</option>
          <option value="Teclado">Ativo</option>
          <option value="Mouse">Inativo</option>
        </select>

        </div>

        <input name="preco" value={form.preco} onChange={handleChange} placeholder="Preço" />
        <input name="estoque" value={form.estoque} onChange={handleChange} placeholder="Quantidade Stoke" />

        <textarea name="descricao" value={form.descricao} onChange={handleChange} placeholder="Descrição do item" rows="5"></textarea>

        <div style={{ textAlign: 'center' }}>
          <button type="submit">SALVAR</button>
        </div>
      </form>
    </div>
  );
}
