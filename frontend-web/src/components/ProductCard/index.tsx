import { ProductType } from '../../types/ProductType';

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
      <div className='card'>
        <img src={imageUri} alt={name} className='card__img' />
        <div className='card__content'>
          <h1 className='card__title'>{name}</h1>
          <h2 className='card__price'>{formatPrice(price)}</h2>
          <h3 className='card__sub-title'>Descrição</h3>
          <p>{description}</p>
        </div>
      </div>
    </a>
  );
};

export { ProducCard };
