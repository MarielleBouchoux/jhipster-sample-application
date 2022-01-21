import { ISaison } from 'app/entities/saison/saison.model';

export interface IEpisode {
  id?: number;
  name?: string | null;
  duree?: number | null;
  saisons?: ISaison | null;
}

export class Episode implements IEpisode {
  constructor(public id?: number, public name?: string | null, public duree?: number | null, public saisons?: ISaison | null) {}
}

export function getEpisodeIdentifier(episode: IEpisode): number | undefined {
  return episode.id;
}
