import { ReactComponent as ImgYoutube } from '../../assets/images/Youtube.svg';
import { ReactComponent as ImgLinkdin } from '../../assets/images/Linkedin.svg';
import { ReactComponent as ImgInstagram } from '../../assets/images/Instagram.svg';

const Footer: React.FC = () => {
  return (
    <div className='container bg__dark py__1'>
      <div className='content'>
        <div className='grid box__center'>
          <p className='text__light'>
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
          </p>
          <nav className='navbar box__center'>
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
          </nav>
        </div>
      </div>
    </div>
  );
};

export { Footer };
