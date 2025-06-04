import React from 'react';
import '../styles/MainCommerce.css'

export default function TechShop() {
  return (
    <>
      <header>
        <div className="container header-content">
          <h1 className="logo">TechShop</h1>
          <nav className="menu">
            <a href="#">Home</a>
            <a href="#">Produtos</a>
            <a href="#">Sobre</a>
            <a href="#">Contato</a>
          </nav>
        </div>
      </header>

      <div className="main-container">
        <aside className="sidebar">
          <h2>Categorias</h2>
          <ul>
            <li><a href="#">Celulares</a></li>
            <li><a href="#">Notebooks</a></li>
            <li><a href="#">Periféricos</a></li>
            <li><a href="#">TVs</a></li>
          </ul>
        </aside>

        <main className="content">
          <h2>Produtos em destaque</h2>
          <div className="products">
            <div className="product-card">
              <img src="https://via.placeholder.com/300" alt="Produto Exemplo" />
              <h3>Produto Exemplo</h3>
              <p>Descrição do produto aqui.</p>
              <span>R$ 999,99</span>
            </div>
            {/* Você pode adicionar mais cards aqui */}
          </div>
        </main>
      </div>

      <footer>
        <p>&copy; 2025 TechShop. Todos os direitos reservados.</p>
      </footer>
    </>
  );
}
