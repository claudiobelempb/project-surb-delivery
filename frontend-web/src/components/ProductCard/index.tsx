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
    <div className='col-3 g-3'>
      <div className='card h-100'>
        <a className='card-link shadow text-decoration-none h-100' href='/'>
          <img src={imageUri} alt={name} className='card-img-top' />
          <div className='card-body'>
            <h5 className='card-title text-danger fw-bold'>{name}</h5>
            <h6 className='card-title text-danger fw-bold'>
              {formatPrice(price)}
            </h6>
            <span className='card-subtitle text-secondary fw-bold'>
              Descrição
            </span>
            <p className='card-text text-secondary'>{description}</p>
          </div>
        </a>
      </div>
    </div>
  );
};

export { ProducCard };
