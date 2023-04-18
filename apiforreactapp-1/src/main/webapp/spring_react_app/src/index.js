import React from 'react';
import ReactDOM from 'react-dom';
import { FontAwesomeIcon } from '@fortawesome/fontawesome-svg-core';
import store from './services/store';

import App from './App';
import './index.css';
import { Provider } from 'react-redux';

ReactDOM.render(
  <Provider store={store} ><App /></Provider>,
  document.getElementById('root')
);
