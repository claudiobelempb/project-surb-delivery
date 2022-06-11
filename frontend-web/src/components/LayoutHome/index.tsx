import { ReactNode } from 'react';
import { Footer } from '../Footer';
import { Header } from '../Header';

type LayoutHomeType = {
  children: ReactNode;
};

const LayoutHome: React.FC<LayoutHomeType> = ({ children }) => {
  return (
    <>
      <Header />
      {children}
      <Footer />
    </>
  );
};

export { LayoutHome };
