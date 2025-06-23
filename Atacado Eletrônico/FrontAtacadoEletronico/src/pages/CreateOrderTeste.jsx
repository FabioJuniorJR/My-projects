// src/components/OrderForm.js
import React, { useState } from 'react';
import '../styles/Orderteste.css'; // Opcional: para estilização

function CreateOrderTeste() {
    // Estado para os dados do pedido principal
    const [orderData, setOrderData] = useState({
        user: { id: '' }, // Assume que o ID do usuário é o que precisamos
        dateOrder: '',
        dateDelivery: '',
        valueOrder: 0.0, // Será calculado/atualizado no backend, mas pode ser um valor inicial
        listOrderProduct: [] // Lista para os itens do pedido
    });

    // Estado para um novo item que está sendo adicionado à lista
    const [newItem, setNewItem] = useState({
        product: { id: '' }, // Assume que o ID do produto é o que precisamos
        quantityProduct: 1,
        priceOrder: 0.0
    });

    // Manipulador de mudança para os campos do pedido principal
    const handleOrderChange = (e) => {
        const { name, value } = e.target;
        if (name === "userId") {
            setOrderData(prevData => ({
                ...prevData,
                user: { id: value ? Number(value) : '' } // Converte para número
            }));
        } else {
            setOrderData(prevData => ({
                ...prevData,
                [name]: value
            }));
        }
    };

    // Manipulador de mudança para os campos de um novo item
    const handleItemChange = (e) => {
        const { name, value } = e.target;
        if (name === "productId") {
            setNewItem(prevItem => ({
                ...prevItem,
                product: { id: value ? Number(value) : '' } // Converte para número
            }));
        } else {
            setNewItem(prevItem => ({
                ...prevItem,
                [name]: value ? Number(value) : value // Converte para número se for numérico
            }));
        }
    };

    // Adiciona um novo item à lista de itens do pedido
    const handleAddItem = () => {
        if (newItem.product.id && newItem.quantityProduct > 0 && newItem.priceOrder >= 0) {
            setOrderData(prevData => ({
                ...prevData,
                listOrderProduct: [...prevData.listOrderProduct, newItem]
            }));
            // Limpa o formulário do item para adicionar o próximo
            setNewItem({
                product: { id: '' },
                quantityProduct: 1,
                priceOrder: 0.0
            });
        } else {
            alert('Por favor, preencha todos os campos do item corretamente.');
        }
    };

    // Remove um item da lista de itens do pedido
    const handleRemoveItem = (indexToRemove) => {
        setOrderData(prevData => ({
            ...prevData,
            listOrderProduct: prevData.listOrderProduct.filter((_, index) => index !== indexToRemove)
        }));
    };

    // Função para enviar os dados para o backend
    const handleSubmit = async (e) => {
        e.preventDefault(); // Previne o comportamento padrão de recarregar a página

        try {
            // URL do seu backend Spring Boot
            const response = await fetch('http://localhost:8080/orders', { // Endpoint POST para Order
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(orderData) // Converte o objeto de estado para JSON
            });

            if (response.ok) {
                const data = await response.json();
                alert('Pedido criado com sucesso! ID: ' + data.numberOrder);
                // Opcional: Resetar o formulário após o sucesso
                setOrderData({
                    user: { id: '' },
                    dateOrder: '',
                    dateDelivery: '',
                    valueOrder: 0.0,
                    listOrderProduct: []
                });
            } else {
                const errorText = await response.text();
                alert('Erro ao criar pedido: ' + errorText);
            }
        } catch (error) {
            console.error('Erro na requisição:', error);
            alert('Erro de conexão ou requisição: ' + error.message);
        }
    };

    return (
        <div className="order-form-container">
            <h2>Criar Novo Pedido</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-section">
                    <h3>Dados do Pedido</h3>
                    <label>
                        ID do Usuário:
                        <input
                            type="number"
                            name="userId"
                            value={orderData.user.id}
                            onChange={handleOrderChange}
                            required
                        />
                    </label>
                    <label>
                        Data do Pedido:
                        <input
                            type="date"
                            name="dateOrder"
                            value={orderData.dateOrder}
                            onChange={handleOrderChange}
                            required
                        />
                    </label>
                    <label>
                        Data de Entrega:
                        <input
                            type="date"
                            name="dateDelivery"
                            value={orderData.dateDelivery}
                            onChange={handleOrderChange}
                            required
                        />
                    </label>
                    {/* O valor total é calculado no backend, então não é um campo editável aqui */}
                    {/* <label>
                        Valor Total:
                        <input
                            type="number"
                            name="valueOrder"
                            value={orderData.valueOrder}
                            onChange={handleOrderChange}
                            step="0.01"
                        />
                    </label> */}
                </div>

                <div className="form-section">
                    <h3>Adicionar Item ao Pedido</h3>
                    <label>
                        ID do Produto:
                        <input
                            type="number"
                            name="productId"
                            value={newItem.product.id}
                            onChange={handleItemChange}
                        />
                    </label>
                    <label>
                        Quantidade:
                        <input
                            type="number"
                            name="quantityProduct"
                            value={newItem.quantityProduct}
                            onChange={handleItemChange}
                            min="1"
                        />
                    </label>
                    <label>
                        Preço Unitário do Item:
                        <input
                            type="number"
                            name="priceOrder"
                            value={newItem.priceOrder}
                            onChange={handleItemChange}
                            step="0.01"
                            min="0"
                        />
                    </label>
                    <button type="button" onClick={handleAddItem}>Adicionar Item</button>
                </div>

                <div className="form-section">
                    <h3>Itens do Pedido ({orderData.listOrderProduct.length})</h3>
                    {orderData.listOrderProduct.length === 0 ? (
                        <p>Nenhum item adicionado ainda.</p>
                    ) : (
                        <ul>
                            {orderData.listOrderProduct.map((item, index) => (
                                <li key={index}>
                                    Produto ID: {item.product.id} | Qtd: {item.quantityProduct} | Preço: R${item.priceOrder.toFixed(2)}
                                    <button type="button" onClick={() => handleRemoveItem(index)}>Remover</button>
                                </li>
                            ))}
                        </ul>
                    )}
                </div>

                <button type="submit" className="submit-button">Criar Pedido Completo</button>
            </form>
        </div>
    );
}

export default CreateOrderTeste;