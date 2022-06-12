import { useEffect, useState } from 'react';
import { LayoutHome } from '../../components/LayoutHome';
import { ProducCard } from '../../components/ProductCard';
import { api } from '../../services/api';
import { ProductType } from '../../types/ProductType';

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
        <div className='container'>
          <div className='content py__1'>
            <div className='grid__3 box__row-center'>
              <h1 className='text__dark-red font__size-small'>
                SIGA AS <br />
                ETAPAS
              </h1>
              <div className=''>
                <p className='text__dark-gray'>
                  <strong className='text__dark-red'>1</strong> Selecione os
                  produtos e localização.
                </p>
                <p className='text__dark-gray'>
                  <strong className='text__dark-red'>2</strong> Depois clique em
                  “ENVIAR PEDIDO"
                </p>
              </div>
              <div className='box__row-end'>
                <button className='btn btn__dark-red'>
                  Pedido enviado com sucesso! Nº 5
                </button>
              </div>
            </div>
          </div>
        </div>
        <div className='container'>
          <div className='content py__2'>
            <div className='grid__4'>
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
