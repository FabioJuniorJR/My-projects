import React, { useState, useEffect } from 'react'; // Importe useEffect
import '../styles/MainCommerce.css'; // Mantenha sua estilização

const MainCommerce = () => {
    // Estados para o menu de categorias (existente)
    const [showHardware, setShowHardware] = useState(false); // Booleans para visibilidade
    const [showPerifericos, setShowPerifericos] = useState(false); // Renomeei para evitar conflito com showHardware
    const [showServicos, setShowServicos] = useState(false);

    // **NOVOS ESTADOS PARA OS PRODUTOS**
    const [products, setProducts] = useState([]); // Armazena a lista de produtos
    const [loading, setLoading] = useState(true); // Indica se os dados estão sendo carregados
    const [error, setError] = useState(null); // Armazena mensagens de erro

    // URL do seu backend Spring Boot
    const API_PRODUCTS_URL = 'http://localhost:8080/product'; // **VERIFIQUE A PORTA!**

    // **useEffect para buscar os produtos quando o componente é montado**
    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const response = await fetch(API_PRODUCTS_URL); // Faz a requisição GET
                if (!response.ok) { // Verifica se a resposta HTTP foi um sucesso (status 2xx)
                    throw new Error(`Erro HTTP: ${response.status} - ${response.statusText}`);
                }
                const data = await response.json(); // Converte a resposta para JSON
                setProducts(data); // Atualiza o estado 'products' com os dados recebidos
            } catch (err) {
                console.error("Falha ao buscar produtos:", err);
                setError("Não foi possível carregar os produtos. Verifique sua conexão ou o servidor."); // Define a mensagem de erro
            } finally {
                setLoading(false); // Finaliza o estado de carregamento
            }
        };

        fetchProducts(); // Chama a função de busca
    }, []); // Array vazio significa que este useEffect roda APENAS uma vez, após a primeira renderização.

    return (
        <div className="app">
            <header className='header'>
                <h1 className='logo'>TechShop</h1>
                <nav className='navHeader'>
                    <ul className='itemsNav'>
                        <a href=''>Home</a>
                        <a href=''>Sobre</a>
                        <a href=''>Contato</a>
                        <a href=''>Perfil</a>
                    </ul>
                </nav>
            </header>

            <div className='AgrupaMenuCategoriaAndViewItems'>
                <div className='category'>
                    <h2 className='CategoriaH2'>Categoria</h2>
                    <nav className='categoryComponent'>
                        <ul className='categoryItems'>
                            {/* Ajustei o estado para showHardware para o primeiro link e showPerifericos para o segundo */}
                            <a className='type' href="" onClick={(e) => {
                                e.preventDefault();
                                setShowHardware(!showHardware); // Alterna a visibilidade de Hardware
                            }}>Hardware</a>
                            {showHardware && ( // Mostra apenas se showHardware for true
                                <>
                                    <li>Processador</li>
                                    <li>Placa de Vídeo</li>
                                    <li>Memória Ram</li>
                                </>
                            )}
                        </ul>
                        <ul>
                            <a className='type' href="" onClick={(e) => {
                                e.preventDefault();
                                setShowPerifericos(!showPerifericos); // Alterna a visibilidade de Periféricos
                            }}> Periféricos</a>
                            {showPerifericos && ( // Mostra apenas se showPerifericos for true
                                <>
                                    <li>Mouse</li>
                                    <li>Teclado</li>
                                    <li>Headset</li>
                                </>
                            )}
                        </ul>
                        <ul>
                            <a className='type' href="" onClick={(e) => {
                                e.preventDefault();
                                setShowServicos(!showServicos); // Alterna a visibilidade de Serviços
                            }}> Serviços </a>
                            {showServicos && ( // Mostra apenas se showServicos for true
                                <>
                                    <li href=''>Windows</li>
                                    <li href=''>Office</li>
                                </>
                            )}
                        </ul>
                    </nav>
                </div>

                {/* **ÁREA ONDE OS PRODUTOS SERÃO EXIBIDOS** */}
                <div className='ViewItems'>
                    <h2>Produtos em Destaque</h2>
                    {loading && <p className="status-message">Carregando produtos...</p>}
                    {error && <p className="error-message">{error}</p>}
                    {!loading && !error && products.length === 0 && (
                        <p className="status-message">Nenhum produto encontrado.</p>
                    )}

                    {!loading && !error && products.length > 0 && (
                        <div className="product-grid">
                          {/*AQUI PEGA CADA PRODUTO COM UM MAP E POR KEY do REACT PARA EXIBIR */}
                            {products.map(product => (
                                <div key={product.id} className="product-card">
                                    {/* Imagem do Produto */}
                                    {product.imgURL ? (<img src={product.imgURL} alt={product.name} className="product-image" />
                                    ) : ( <div className="no-image">Sem Imagem</div> // Placeholder
                                    )}

                                    {/* Informações do Produto */}
                                    <h3 className="product-name">{product.name}</h3>
                                    <p className="product-category">Categoria: {product.category}</p>
                                    <p className="product-description">{product.description}</p>
                                    <p className="product-price">Preço: R$ {product.price ? product.price.toFixed(2).replace('.', ',') : 'N/A'}</p> {/* Formata e usa vírgula */}
                                    <p className="product-stock">Estoque: {product.qtdeStoke}</p>
                                    {product.manufacture && (
                                        <p className="product-manufacturer">Fabricante: {product.manufacture.name}</p>
                                    )}
                                    <button className="add-to-cart-button">Adicionar ao Carrinho</button>
                                </div>
                            ))}
                        </div>
                    )}
                </div>
            </div>

            <footer className="footer">
                <p>&copy; 2025 TechShop. Todos os direitos reservados.</p>
            </footer>
        </div>
    );
}

export default MainCommerce;