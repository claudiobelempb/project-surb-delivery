import { Link } from 'react-router-dom';

import styles from './Home.module.css';

import { LayoutHome } from '../../components/LayoutHome';
import { ReactComponent as ImgBackground } from '../../assets/images/Imagem.svg';

const HomePage: React.FC = () => {
  return (
    <LayoutHome>
      <main className={`container ${styles.home__container}`}>
        <div className={`content`}>
          <div className='box large'>
            <div className=''>
              <h2 className={styles.home__container_title}>
                Faça seu pedido que entregamos pra você!!!
              </h2>
              <p className={styles.home__container_p}>
                Escolha o seu pedido e em poucos minutos levaremoss na sua porta
              </p>
              <Link to={'/products'}>
                <button className={styles.home__container_button}>
                  FAZER PEDIDO
                </button>
              </Link>
            </div>
            <div className=''>
              <ImgBackground className={styles.home__container_svg} />
            </div>
          </div>
        </div>
      </main>
    </LayoutHome>
  );
};

export default HomePage;
