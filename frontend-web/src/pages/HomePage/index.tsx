import { Link } from 'react-router-dom';

import { LayoutHome } from '../../components/LayoutHome';
import { ReactComponent as ImgBackground } from '../../assets/images/Imagem.svg';

const HomePage: React.FC = () => {
  return (
    <LayoutHome>
      <main className='container d-flex justify-content-center align-items-center'>
        <div className='row'>
          <div className='col'>
            <h2
              className='text-dark display-4 fw-bold'
              style={{ maxWidth: '490px' }}
            >
              Faça seu pedido que entregamos pra você!!!
            </h2>
            <p className='lead text-secondary' style={{ maxWidth: '490px' }}>
              Escolha o seu pedido e em poucos minutos levaremoss na sua porta
            </p>
            <Link to={'/products'}>
              <button className='btn btn-danger btn-lg text-light fw-bold'>
                FAZER PEDIDO
              </button>
            </Link>
          </div>
          <div className='col'>
            <ImgBackground className='img-fluid' />
          </div>
        </div>
      </main>
    </LayoutHome>
  );
};

export default HomePage;
