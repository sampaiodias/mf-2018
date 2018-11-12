/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class IndividuoDTOTest {
    private IndividuoDTO getIndividuoDeTestes() {
        final IndividuoDTO individuo = new IndividuoDTO();
        final LocalDate dataDeTestes = LocalDate.now();

        final NacionalidadeDTO nacionalidade = new NacionalidadeDTO();
        nacionalidade.setCodigoEstado("GO");
        nacionalidade.setCodigoMunicipio(1234);
        nacionalidade.setCodigoPais(55);
        nacionalidade.setDataEntradaPais(dataDeTestes);

        final DataComAcuraciaDTO nascimento = new DataComAcuraciaDTO();
        nascimento.setData(dataDeTestes);
        nascimento.setAcuracia("...");

        final DataComAcuraciaDTO obito = new DataComAcuraciaDTO();
        obito.setData(dataDeTestes);
        obito.setAcuracia("...");

        final DadoDemograficoDTO demo = new DadoDemograficoDTO();
        demo.setCodigoNascimentoOrdem(1);
        demo.setCodigoNascimentoPluraridade(1);
        demo.setCodigoNascimentoSeguimento("A");
        demo.setCodigoObitoFonte(1);
        demo.setCodigoRaca(1);
        demo.setCodigoSexo(1);
        demo.setCodigoSituacaoFamiliar(1);
        demo.setComentario("Comentário...");
        demo.setMae("MARIA DA SILVA");
        demo.setNacionalidade(nacionalidade);
        demo.setNascimento(nascimento);
        demo.setObito(obito);
        demo.setPai("JOÃO DA SILVA");

        final List<Comunicacao> comunicacoes = new ArrayList<>();
        final Comunicacao comunicacao1 = new Comunicacao();
        comunicacao1.setCodigoMeio(1);
        comunicacao1.setCodigoPreferencia("A");
        comunicacao1.setCodigoUso(1);
        comunicacao1.setDetalhe("(11) 3000-0000");
        final Comunicacao comunicacao2 = new Comunicacao();
        comunicacao2.setCodigoMeio(1);
        comunicacao2.setCodigoPreferencia("B");
        comunicacao2.setCodigoUso(2);
        comunicacao2.setDetalhe("(11) 3000-0000");
        comunicacoes.add(comunicacao2);

        final DataComAcuraciaDTO enderecoFim = new DataComAcuraciaDTO();
        enderecoFim.setData(dataDeTestes);
        enderecoFim.setAcuracia("...");

        final DataComAcuraciaDTO enderecoInicio = new DataComAcuraciaDTO();
        enderecoInicio.setData(dataDeTestes);
        nascimento.setAcuracia("...");

        final List<EnderecoLinhaDTO> linhas = new ArrayList<>();
        final EnderecoLinhaDTO linha1 = new EnderecoLinhaDTO();
        linha1.setLinha("RUA A");
        linha1.setOrdem(0);
        linhas.add(linha1);
        final EnderecoLinhaDTO linha2 = new EnderecoLinhaDTO();
        linha2.setLinha("RUA B");
        linha2.setOrdem(1);
        linhas.add(linha2);

        final List<EnderecoDTO> enderecos = new ArrayList<>();
        final EnderecoDTO endereco = new EnderecoDTO();
        endereco.setBairro("BAIRRO TESTE");
        endereco.setCaixaPostal("123");
        endereco.setCep("12345-678");
        endereco.setCodigoEstado("GO");
        endereco.setCodigoMunicipio(1234);
        endereco.setCodigoTipo(1);
        endereco.setCodigoPais(55);
        endereco.setDataFim(enderecoFim);
        endereco.setDataInicio(enderecoInicio);
        endereco.setDistrito("DISTRITO TESTE");
        endereco.setId(1234);
        endereco.setLinhas(linhas);
        enderecos.add(endereco);

        final CertidaoDTO certidao = new CertidaoDTO();
        certidao.setCartorio("CARTORIO TESTE");
        certidao.setCodigoTipo(0);
        certidao.setFolha(1);
        certidao.setLivro(2);
        certidao.setTermo(3);

        final CtpsDTO ctps = new CtpsDTO();
        ctps.setCodigoEstado("GO");
        ctps.setSerie(1);

        final TituloEleitoralDTO titulo = new TituloEleitoralDTO();
        titulo.setSessao(1);
        titulo.setZona(1);

        final List<IdentificadorDTO> identificadores = new ArrayList<>();
        final IdentificadorDTO identificador = new IdentificadorDTO();
        identificador.setCertidao(certidao);
        identificador.setCodigoArea(1);
        identificador.setCodigoTipo("...");
        identificador.setCtps(ctps);
        identificador.setData(dataDeTestes);
        identificador.setDesignacao("SR");
        identificador.setEmissor("GOVERNO FEDERAL");
        identificador.setId(1234);
        identificador.setIdIndividuo(1234);
        identificador.setTituloEleitoral(titulo);
        identificadores.add(identificador);

        final List<RepresentacaoDTO> representacoes = new ArrayList<>();
        final RepresentacaoDTO representacao = new RepresentacaoDTO();
        representacao.setAlternativa("JOÃO NINGUÉM");
        representacao.setUtilizacao("A");
        representacoes.add(representacao);

        final List<UtilizacaoDTO> utilizacoes = new ArrayList<>();
        final UtilizacaoDTO utilizacao = new UtilizacaoDTO();
        utilizacao.setDataFinal(dataDeTestes);
        utilizacao.setDataInicial(dataDeTestes);
        utilizacao.setIdIdentificador(1234);
        utilizacao.setCodigoUso(1);
        utilizacoes.add(utilizacao);

        final List<Nome> nomes = new ArrayList<>();
        final Nome nome = new Nome();
        nome.setCodigoPreferido(1);
        nome.setCodigoUsoCondicional(3);
        nome.setId(1234);
        nome.setNomes("JOAO");
        nome.setRepresentacoes(representacoes);
        nome.setSobrenomes("NINGUÉM");
        nome.setSufixos("SR.");
        nome.setTitulos("DR.");
        nome.setUtilizacoes(utilizacoes);
        nomes.add(nome);

        final List<VinculoDTO> vinculos = new ArrayList<>();
        final VinculoDTO vinculo = new VinculoDTO();
        vinculo.setDataFim(dataDeTestes);
        vinculo.setDataInicio(dataDeTestes);
        vinculo.setIdIdentificador(1234);
        vinculo.setRelacionamento("PAI");
        vinculos.add(vinculo);

        individuo.setId(1234L);
        individuo.setDadoDemografico(demo);
        individuo.setComunicacoes(comunicacoes);
        individuo.setEnderecos(enderecos);
        individuo.setIdentificadores(identificadores);
        individuo.setNomes(nomes);
        individuo.setVinculos(vinculos);
        return individuo;
    }
    
    private boolean haveEqualFields(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void toAndFromJson() {
        final IndividuoDTO individuo = getIndividuoDeTestes();
        final String json = individuo.toJson();
        final IndividuoDTO individuoObtido = IndividuoDTO.fromJson(json);
        Assertions.assertTrue(haveEqualFields(individuo, individuoObtido));
    }

    @Test
    public void toAndFromXml() throws JAXBException {
        final IndividuoDTO individuo = getIndividuoDeTestes();
        final String xml = individuo.toXml();
        final IndividuoDTO individuoObtido = IndividuoDTO.fromXml(xml);
        Assertions.assertTrue(haveEqualFields(individuo, individuoObtido));
    }
}