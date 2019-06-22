import React from "react";
import Tile from "./Tile";

const Tiles = ({movies}) => movies.map((movie, i) => <Tile key={i} movie={movie}/>);

export default Tiles;