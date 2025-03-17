import dayjs from 'dayjs/esm';

import { IAluno, NewAluno } from './aluno.model';

export const sampleWithRequiredData: IAluno = {
  id: 8806,
  nome: 'boo tomorrow',
  email: 'Genevieve_Weber15@yahoo.com',
  dataNascimento: dayjs('2025-03-17'),
};

export const sampleWithPartialData: IAluno = {
  id: 2189,
  nome: 'insecure supposing untimely',
  email: 'Lavern_Prosacco95@hotmail.com',
  dataNascimento: dayjs('2025-03-16'),
};

export const sampleWithFullData: IAluno = {
  id: 25732,
  nome: 'oof near likewise',
  email: 'Kaleb_Waters75@gmail.com',
  dataNascimento: dayjs('2025-03-16'),
};

export const sampleWithNewData: NewAluno = {
  nome: 'energetically yet webbed',
  email: 'Ebony_Mayer@hotmail.com',
  dataNascimento: dayjs('2025-03-17'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
