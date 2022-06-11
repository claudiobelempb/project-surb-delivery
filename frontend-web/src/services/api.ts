import axios from 'axios';

export const api = axios.create({
  baseURL: 'https://surb-delivery.herokuapp.com',
  headers: { 'Access-Control-Allow-Origin': '*' }
});
