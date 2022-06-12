import { Link } from 'react-router-dom';
import { ReactComponent as ImgLogo } from '../../assets/images/Logotipo.svg';

const Header: React.FC = () => {
  return (
    <div className='container bg__dark-red '>
      <div className='content py__1'>
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
