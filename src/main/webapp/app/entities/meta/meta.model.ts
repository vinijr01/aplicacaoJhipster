import { IAluno } from 'app/entities/aluno/aluno.model';

export interface IMeta {
  id: number;
  area?: string | null;
  notaEsperada?: number | null;
  aluno?: Pick<IAluno, 'id' | 'email'> | null;
}

export type NewMeta = Omit<IMeta, 'id'> & { id: null };
