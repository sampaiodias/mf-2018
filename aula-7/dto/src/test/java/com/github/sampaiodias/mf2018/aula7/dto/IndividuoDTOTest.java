/*
 * Copyright (c) 2018.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.mf2018.aula7.dto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

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

        final List<ComunicacaoDTO> comunicacoes = new ArrayList<>();
        final ComunicacaoDTO comunicacao1 = new ComunicacaoDTO();
        comunicacao1.setCodigoMeio(1);
        comunicacao1.setCodigoPreferencia("A");
        comunicacao1.setCodigoUso(1);
        comunicacao1.setDetalhe("(11) 3000-0000");
        final ComunicacaoDTO comunicacao2 = new ComunicacaoDTO();
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

        final List<NomeDTO> nomes = new ArrayList<>();
        final NomeDTO nome = new NomeDTO();
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
    
    private boolean isEquals(final Object a, final Object b) {
        return EqualsBuilder.reflectionEquals(a, b, false, Object.class, true);
    }

    @Test
    public void individuoToAndFromJsonTest() {
        final IndividuoDTO individuo = getIndividuoDeTestes();
        final String json = individuo.toJson();
        final IndividuoDTO individuoObtido = IndividuoDTO.fromJson(json);
        Assertions.assertTrue(isEquals(individuo, individuoObtido));
    }

    @Test
    public void individuoToAndFromXmlTest() throws JAXBException {
        final IndividuoDTO individuo = getIndividuoDeTestes();
        final String xml = individuo.toXml();
        final IndividuoDTO individuoObtido = IndividuoDTO.fromXml(xml);
        Assertions.assertTrue(isEquals(individuo, individuoObtido));
    }
    
    @Test
    public void individuoJsonSchemaTest() throws IOException {
        File resourcesDirectory = new File("src/test/resources");
        final String jsonFileName = "Individuo.json";
        try {
            File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/json-schema/" + jsonFileName);
            BufferedReader brSchema = 
                    new BufferedReader(new FileReader(schemaFile));
            File jsonFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/json/" + jsonFileName);
            BufferedReader brJson = 
                    new BufferedReader(new FileReader(jsonFile));
            
            JSONObject rawSchema = new JSONObject(new JSONTokener(brSchema));
            org.everit.json.schema.Schema schema = 
                    org.everit.json.schema.loader.SchemaLoader.load(rawSchema);
            JSONObject json = new JSONObject(new JSONTokener(brJson));
            schema.validate(json);
            
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
    
    @Test
    public void individuoXmlSchemaTest() throws 
            IOException, JAXBException, SAXException {
        File resourcesDirectory = new File("src/test/resources");
        File schemaFile = new File(resourcesDirectory.getAbsolutePath() + 
                "/xml-schema/individuo.xsd");
        Source xmlFile = 
                new StreamSource(new File(resourcesDirectory.getAbsolutePath() +
                        "/xml/Individuo.xml"));
        SchemaFactory schemaFactory = SchemaFactory
            .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
}