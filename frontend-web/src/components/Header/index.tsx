import { Link } from 'react-router-dom';
import { ReactComponent as ImgLogo } from '../../assets/images/Logotipo.svg';

const Header: React.FC = () => {
  return (
    <div className='container-fluid bg-danger py-4'>
      <div className='container'>
        <Link to={'/'}>
          <div className=''>
            <ImgLogo />
          </div>
        </Link>
      </div>
    </div>
  );
};

export { Header };
