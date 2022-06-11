import { Link } from 'react-router-dom';
import { ReactComponent as ImgLogo } from '../../assets/images/Logotipo.svg';

import styles from './styles.module.css';

const Header: React.FC = () => {
  return (
    <div className={`container ${styles.header__container}`}>
      <div className={`content`}>
        <Link to={'/'}>
          <div className={styles.header__container_link}>
            <ImgLogo />
          </div>
        </Link>
      </div>
    </div>
  );
};

export { Header };
