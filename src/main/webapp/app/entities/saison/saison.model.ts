import { IEpisode } from 'app/entities/episode/episode.model';
import { ISerie } from 'app/entities/serie/serie.model';

export interface ISaison {
  id?: number;
  name?: string | null;
  episodes?: IEpisode[] | null;
  series?: ISerie | null;
}

export class Saison implements ISaison {
  constructor(public id?: number, public name?: string | null, public episodes?: IEpisode[] | null, public series?: ISerie | null) {}
}

export function getSaisonIdentifier(saison: ISaison): number | undefined {
  return saison.id;
}
