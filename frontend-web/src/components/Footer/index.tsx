import { ReactComponent as ImgYoutube } from '../../assets/images/Youtube.svg';
import { ReactComponent as ImgLinkdin } from '../../assets/images/Linkedin.svg';
import { ReactComponent as ImgInstagram } from '../../assets/images/Instagram.svg';

const Footer: React.FC = () => {
  return (
    <div className='container-fluid bg-dark py-1'>
      <div className='container'>
        <div className='grid box__center'>
          <p className='text-light text-center'>
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
          </p>
          <nav className='d-flex justify-content-center'>
            <ul className='nav'>
              <li className='nav-item'>
                <a className='nav-link' href='/'>
                  <ImgYoutube />
                </a>
              </li>
              <li className='nav-item'>
                <a className='nav-link' href='/'>
                  <ImgLinkdin />
                </a>
              </li>
              <li className='nav-item'>
                <a className='nav-link' href='/'>
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
