import { ProducCard } from '../../components/ProductCard';
import styles from './Product.module.css';

const ProductPage: React.FC = () => {
  return (
    <main>
      <div className={`container ${styles.product__container}`}>
        <div className='content'>
          <div className='box__medium'>
            <h1>SIGA AS ETAPAS</h1>
          </div>
          <div className='box__medium justify__content_start flex__direction_column'>
            <p>
              <strong>1</strong> Selecione os produtos e localização.
            </p>
            <p>
              <strong>2</strong> Depois clique em “ENVIAR PEDIDO"
            </p>
          </div>
          <div className='box__medium justify__content_end'>
            <button className='btn__red_medium'>
              Pedido enviado com sucesso! Nº 5
            </button>
          </div>
        </div>
      </div>
      <div className='container'>
        <div className='content'>
          <div className='box'>
            <ProducCard StyleValue='active' />
            <ProducCard />
            <ProducCard />
            <ProducCard />
          </div>
        </div>
      </div>
    </main>
  );
};

export default ProductPage;