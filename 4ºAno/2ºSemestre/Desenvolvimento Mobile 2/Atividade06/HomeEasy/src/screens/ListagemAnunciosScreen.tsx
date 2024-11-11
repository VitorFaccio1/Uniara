import React, { useEffect, useState } from 'react';
import { FlatList, Text, View, Button, StyleSheet, TouchableOpacity, ActivityIndicator } from 'react-native';
import { buscarAnuncios } from '../services/api';

interface Anuncio {
  id: number;
  titulo: string;
  descricao: string;
}

const ListagemAnunciosScreen = ({ navigation }: any) => {
  const [anuncios, setAnuncios] = useState<Anuncio[]>([]);
  const [carregando, setCarregando] = useState<boolean>(false);
  const [erro, setErro] = useState<string | null>(null);

  useEffect(() => {
    const carregarAnuncios = async () => {
      setCarregando(true);
      setErro(null);
      try {
        const dados = await buscarAnuncios();
        setAnuncios(dados);
      } catch (erro) {
        setErro('Erro ao carregar anúncios. Tente novamente mais tarde.');
        console.error(erro);
      } finally {
        setCarregando(false);
      }
    };

    carregarAnuncios();
  }, []);

  const renderizarItem = ({ item }: { item: Anuncio }) => (
    <View style={estilos.cartao}>
      <Text style={estilos.titulo}>{item.titulo}</Text>
      <Text>{item.descricao}</Text>
    </View>
  );

  return (
    <View style={estilos.container}>
      <Text style={estilos.cabecalho}>Anúncios</Text>
      {carregando ? (
        <ActivityIndicator size="large" color="#0000ff" />
      ) : erro ? (
        <Text style={estilos.erro}>{erro}</Text>
      ) : (
        <FlatList
          data={anuncios}
          renderItem={renderizarItem}
          keyExtractor={(item) => item.id.toString()}
        />
      )}
      <View style={estilos.botaoContainer}>
        <Button title="Criar Novo Anúncio" onPress={() => navigation.navigate('CriarAnuncio')} />
      </View>
    </View>
  );
};

const estilos = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  cabecalho: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  cartao: {
    padding: 10,
    marginBottom: 15,
    borderWidth: 1,
    borderRadius: 8,
    borderColor: '#ddd',
    backgroundColor: '#f9f9f9',
  },
  titulo: {
    fontSize: 18,
    fontWeight: 'bold',
  },
  erro: {
    color: 'red',
    textAlign: 'center',
    marginTop: 20,
  },
  botaoContainer: {
    marginTop: 20,
    alignItems: 'center',
  },
});

export default ListagemAnunciosScreen;