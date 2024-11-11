import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import ListagemAnunciosScreen from './src/screens/ListagemAnunciosScreen';
import CriarAnuncioScreen from './src/screens/CriarAnuncioScreen';

const Stack = createStackNavigator();

const AppNavigator = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="ListagemAnuncios">
        <Stack.Screen
          name="ListagemAnuncios"
          component={ListagemAnunciosScreen}
          options={{ title: 'Anúncios' }}
        />
        <Stack.Screen
          name="CriarAnuncio"
          component={CriarAnuncioScreen}
          options={{ title: 'Criar Anúncio' }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default AppNavigator;
