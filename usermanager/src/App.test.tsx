import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders user list dashboard', () => {
  render(<App />);
  const linkElement = screen.getByText(/USER LIST/i);
  expect(linkElement).toBeInTheDocument();
});
