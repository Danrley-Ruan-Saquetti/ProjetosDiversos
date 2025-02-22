create database cassino;

create table jogador(
id int auto_increment,
nome varchar(50) not null,
senha varchar(9) not null,
saldo decimal(11,2),
vitoriaRoleta int, derrotaRoleta int, totalRoleta int, vR_dR decimal(5,2),
vitoriaCacaNiquel int, derrotaCacaNiquel int, totalCacaNiquel int, vC_dC decimal(5,2),
vitoriaBingo int, derrotaBingo int, totalBingo int, vB_dB decimal(5,2),
vitoriaGeneral int, derrotaGeneral int, totalGeneral int, vG_dG decimal(5,2),
vitoriaPoker int, derrotaPoker int, totalPoker int, vP_dP decimal(5,2),
vitoriaTotal int, derrotaTotal int, totalJogos int, vT_dT decimal(5,2),
saldoLucrado decimal(11,2), saldoPerdido decimal(11,2),
primary key(id)
);