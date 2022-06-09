import ImgPizza from '../../assets/images/gettyimages.jpg';

import styles from './ProductCard.module.css';

type ProductCardType = {
  StyleValue?: string;
};

const ProducCard: React.FC<ProductCardType> = ({ StyleValue }) => {
  return (
    <a className={`${StyleValue}`} href='/'>
      <div className={`card ${styles.product__card}`}>
        <img
          src={ImgPizza}
          alt='pizza'
          className={`${styles.product__card_img}`}
        />
        <div className={`${styles.product__card_content}`}>
          <h1 className={`${styles.product__card_title}`}>Pizza Calabresa</h1>
          <h2 className={`${styles.product__card_price}`}>R$ 35,90</h2>
          <h3 className={`${styles.product__card_description}`}>Descrição</h3>
          <p>
            Uma deliciosa combinação de Linguiça Calabresa, rodelas de cebolas
            frescas, azeitonas pretas, mussarela, polpa de tomate, orégano e
            massa especial.
          </p>
        </div>
      </div>
    </a>
  );
};

export { ProducCard };
