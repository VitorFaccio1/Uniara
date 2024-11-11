import React, { useState } from 'react';
import { TextInput, Button, View, StyleSheet, Text } from 'react-native';
import { criarAnuncio } from '../services/api';

const CriarAnuncioScreen = ({ navigation }: any) => {
  const [titulo, setTitulo] = useState<string>('');
  const [descricao, setDescricao] = useState<string>('');

  const handleCriarAnuncio = async () => {
    try {
      const dadosAnuncio = { titulo, descricao };
      await criarAnuncio(dadosAnuncio);
      navigation.goBack();
    } catch (erro) {
      console.error('Erro ao criar anúncio:', erro);
    }
  };

  return (
    <View style={estilos.container}>
      <Text style={estilos.cabecalho}>Criar Novo Anúncio</Text>
      <TextInput
        style={estilos.input}
        placeholder="Título"
        value={titulo}
        onChangeText={setTitulo}
      />
      <TextInput
        style={estilos.input}
        placeholder="Descrição"
        value={descricao}
        onChangeText={setDescricao}
      />
      <Button title="Criar Anúncio" onPress={handleCriarAnuncio} />
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
  input: {
    height: 40,
    borderColor: '#ccc',
    borderWidth: 1,
    marginBottom: 15,
    paddingLeft: 10,
  },
});

export default CriarAnuncioScreen;
