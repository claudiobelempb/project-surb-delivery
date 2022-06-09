import { ReactComponent as ImgBackground } from '../../assets/images/Imagem.svg';

import styles from './Home.module.css';

const HomePage: React.FC = () => {
  return (
    <div className={`container ${styles.home__container}`}>
      <div className={`content`}>
        <div className='box__large'>
          <h2 className={styles.home__container_title}>
            Faça seu pedido que entregamos pra você!!!
          </h2>
          <p className={styles.home__container_p}>
            Escolha o seu pedido e em poucos minutos levaremoss na sua porta
          </p>
          <button className={styles.home__container_button}>
            FAZER PEDIDO
          </button>
        </div>
        <div className='box__large'>
          <ImgBackground className={styles.home__container_svg} />
        </div>
      </div>
    </div>
  );
};

export default HomePage;
