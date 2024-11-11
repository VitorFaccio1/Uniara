import axios from 'axios';

const api = axios.create({
  baseURL: 'https://localhost:7149', 
});

export const buscarAnuncios = async () => {
  try {
    const resposta = await api.get('/Anuncios');
    return resposta.data;
  } catch (erro) {
    console.error('Erro ao buscar anúncios:', erro);
    throw erro;
  }
};

export const criarAnuncio = async (dadosAnuncio: { titulo: string; descricao: string }) => {
  try {
    const resposta = await api.post('/Anuncios', dadosAnuncio); 
    return resposta.data;
  } catch (erro) {
    console.error('Erro ao criar anúncio:', erro);
    throw erro;
  }
};