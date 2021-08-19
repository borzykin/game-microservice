create table if not exists games
(
    id uuid not null,
    winner uuid not null,
    looser uuid not null,
    "scoreGained" double precision not null,
    "scoreLost" double precision not null,
    "createdOn" timestamp
);
