import { useEffect, useState } from 'react';
import { FaSearch } from 'react-icons/fa';
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
      <main className='container '>
        <div className='row py-4'>
          <div className='col d-flex align-items-center'>
            <h1 className='fs-4 fw-bold text-danger'>
              SIGA AS <br />
              ETAPAS
            </h1>
          </div>
          <div className='col d-flex flex-column justify-content-center'>
            <p className='text-secondary m-0'>
              <strong className='text-danger'>1</strong> Selecione os produtos e
              localização.
            </p>
            <p className='text-secondary m-0'>
              <strong className='text-danger'>2</strong> Depois clique em
              “ENVIAR PEDIDO"
            </p>
          </div>
          <div className='col d-flex justify-content-end align-items-center'>
            <button className='btn btn-danger text-light fw-bold '>
              Pedido enviado com sucesso! Nº 5
            </button>
          </div>
        </div>

        <div className='row py-4'>
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

        <div className='row py-4 rounded bg-light'>
          <div className='col'>
            <h2 className='fw-bold text-center text-secondary'>
              Selecione onde o pedido deve ser entregue:
            </h2>
            <div className='bg-light p-3 rounded'>
              <div className='bg-light p-3 rounded-3 position-relative'>
                <form className='bg-linght d-flex p-5 position-absolute top-25 start-0 end-0'>
                  <input
                    className='form-control rounded-0 border-0 border-secondary border-top-0 border-start-0 border-end-0 border-bottom bg-light'
                    placeholder='Rua Abraão, 1314'
                    type='text'
                  />
                  <button className='bg-light border-0 border-0 border-secondary border-top-0 border-start-0 border-end-0 border-bottom'>
                    <FaSearch className='m-3 fs-4 text-secondary' />
                  </button>
                </form>
                <iframe
                  src='https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d15850.173879094822!2d-35.532939!3d-6.7033204!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spt-BR!2sbr!4v1655026151515!5m2!1spt-BR!2sbr'
                  style={{
                    border: '0',
                    width: '100%',
                    height: '600px'
                  }}
                ></iframe>
              </div>
            </div>
          </div>
        </div>

        <div className='row d-flex align-items-center py-4 my-4 rounded bg-danger'>
          <div className='col'>
            <p className='text-light m-0 fs-6'>
              <strong className='fw-bold'>2</strong> PEDIDOS SELECIONADOS
            </p>
            <p className='text-light m-0 fs-5'>
              <strong className='fw-bold'>R$ 71,80</strong> VALOR TOTAL
            </p>
          </div>
          <div className='col d-flex justify-content-end'>
            <button className='btn btn-light btn-lg text-danger fw-bolder'>
              FAZER PEDIDO
            </button>
          </div>
        </div>
      </main>
    </LayoutHome>
  );
};

export default ProductPage;
