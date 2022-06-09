import styles from './Footer.module.css';

import { ReactComponent as ImgYoutube } from '../../assets/images/Youtube.svg';
import { ReactComponent as ImgLinkdin } from '../../assets/images/Linkedin.svg';
import { ReactComponent as ImgInstagram } from '../../assets/images/Instagram.svg';

const Footer: React.FC = () => {
  return (
    <div className={`container ${styles.footer__container}`}>
      <div className='content'>
        <div className='box'>
          <div className='box__full justify__content_center flex__direction_column'>
            <p>
              App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            </p>
            <ul>
              <li>
                <a href='/'>
                  <ImgYoutube />
                </a>
              </li>
              <li>
                <a href='/'>
                  <ImgLinkdin />
                </a>
              </li>
              <li>
                <a href='/'>
                  <ImgInstagram />
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};

export { Footer };
