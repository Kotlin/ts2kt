export type GeographicScope = 'city' | 'state' | 'country' | 'world';

export interface MapGenerator {
    generate(scope: GeographicScope)
}
