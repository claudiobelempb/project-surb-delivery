import { ProductType } from '../../types/ProductType';

import styles from './ProductCard.module.css';

const ProducCard: React.FC<ProductType> = ({
  name,
  price,
  description,
  imageUri
}) => {
  const formatPrice = (price: number) => {
    const formatter = new Intl.NumberFormat('pt-BR', {
      style: 'currency',
      currency: 'BRL',
      minimumFractionDigits: 2
    });
    return formatter.format(price);
  };
  return (
    <a href='/'>
      <div className={`card ${styles.product__card}`}>
        <img
          src={imageUri}
          alt={name}
          className={`${styles.product__card_img}`}
        />
        <div className={`${styles.product__card_content}`}>
          <h1 className={`${styles.product__card_title}`}>{name}</h1>
          <h2 className={`${styles.product__card_price}`}>
            {formatPrice(price)}
          </h2>
          <h3 className={`${styles.product__card_description}`}>Descrição</h3>
          <p>{description}</p>
        </div>
      </div>
    </a>
  );
};

export { ProducCard };
