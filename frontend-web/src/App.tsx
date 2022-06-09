import React from 'react';

import { Footer } from './components/Footer';
import { Header } from './components/Header';
import HomePage from './pages/HomePage';
// import ProductPage from './pages/ProductPage';

import styles from './App.module.css';

function App() {
  return (
    <div className={styles.App__container}>
      <Header />
      <HomePage />
      <Footer />
    </div>
  );
}

export default App;
