import { Link } from 'react-router-dom';

import { LayoutHome } from '../../components/LayoutHome';
import { ReactComponent as ImgBackground } from '../../assets/images/Imagem.svg';

const HomePage: React.FC = () => {
  return (
    <LayoutHome>
      <main className='container'>
        <div className='content'>
          <div className='grid__2'>
            <div className=''>
              <h2 className='font__size-medium text__dark py__3'>
                Faça seu pedido que entregamos pra você!!!
              </h2>
              <p className='font__size-small text__dark-gray py__1'>
                Escolha o seu pedido e em poucos minutos levaremoss na sua porta
              </p>
              <Link to={'/products'}>
                <button className='btn btn__dark-red'>FAZER PEDIDO</button>
              </Link>
            </div>
            <div className=''>
              <ImgBackground className='' />
            </div>
          </div>
        </div>
      </main>
    </LayoutHome>
  );
};

export default HomePage;
