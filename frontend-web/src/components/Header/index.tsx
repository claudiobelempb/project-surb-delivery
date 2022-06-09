import { ReactComponent as ImgLogo } from '../../assets/images/Logotipo.svg';

import styles from './styles.module.css';

const Header: React.FC = () => {
  return (
    <div className={`container ${styles.header__container}`}>
      <div className={`content`}>
        <a className={styles.header__container_link} href='/'>
          <ImgLogo />
        </a>
      </div>
    </div>
  );
};

export { Header };
