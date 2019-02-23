function Gruppo(id_gruppo, nome, url_photo){
	this.id_gruppo = id_gruppo;
	this.nome = nome;
	this.url_photo = url_photo;

}
function Lp (id_lp, titolo, anno, genere, id_gruppo, nome_gruppo){
	this.id_lp = id_lp;
	this.titolo = titolo;
	this.anno = anno;
	this.genere = genere;
    this.id_gruppo = id_gruppo;
    this.nome_gruppo = nome_gruppo;
}
