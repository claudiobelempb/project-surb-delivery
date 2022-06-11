import { useEffect, useState } from 'react';
import { LayoutHome } from '../../components/LayoutHome';
import { ProducCard } from '../../components/ProductCard';
import { api } from '../../services/api';
import { ProductType } from '../../types/ProductType';
import styles from './Product.module.css';

const ProductPage: React.FC = () => {
  const [products, setProducts] = useState<ProductType[]>([]);

  useEffect(() => {
    (async () => {
      try {
        const products = await api.get(`/products`);

        setProducts(products.data);
      } catch (error) {
        console.log(error, 'Errror');
      }
    })();
  }, []);

  return (
    <LayoutHome>
      <main>
        <div className={`container ${styles.product__container}`}>
          <div className='content'>
            <div className='box medium'>
              <h1>SIGA AS ETAPAS</h1>
              <div className=''>
                <p>
                  <strong>1</strong> Selecione os produtos e localização.
                </p>
                <p>
                  <strong>2</strong> Depois clique em “ENVIAR PEDIDO"
                </p>
              </div>
              <div className='justify__content_end'>
                <button className='btn__red_medium'>
                  Pedido enviado com sucesso! Nº 5
                </button>
              </div>
            </div>
          </div>
        </div>
        <div className='container'>
          <div className='content'>
            <div className='box small'>
              {products.map(product => (
                <ProducCard
                  key={product.id}
                  name={product.name}
                  price={product.price}
                  description={product.description}
                  imageUri={product.imageUri}
                />
              ))}
            </div>
          </div>
        </div>
      </main>
    </LayoutHome>
  );
};

export default ProductPage;
