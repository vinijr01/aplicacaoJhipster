import { IMeta, NewMeta } from './meta.model';

export const sampleWithRequiredData: IMeta = {
  id: 17187,
  area: 'scorpion where',
  notaEsperada: 10267,
};

export const sampleWithPartialData: IMeta = {
  id: 15622,
  area: 'once across likewise',
  notaEsperada: 8598,
};

export const sampleWithFullData: IMeta = {
  id: 32703,
  area: 'cinch',
  notaEsperada: 19360,
};

export const sampleWithNewData: NewMeta = {
  area: 'pish huddle',
  notaEsperada: 15598,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
