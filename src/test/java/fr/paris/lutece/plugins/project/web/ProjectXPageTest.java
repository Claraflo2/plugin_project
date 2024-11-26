/*
 * Copyright (c) 2002-2024, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES LOSS OF USE, DATA, OR PROFITS OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */

package fr.paris.lutece.plugins.project.web;

import fr.paris.lutece.portal.service.admin.AccessDeniedException;
import fr.paris.lutece.test.LuteceTestCase;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import java.io.IOException;
import fr.paris.lutece.portal.service.security.SecurityTokenService;
import java.util.List;
import fr.paris.lutece.portal.service.message.SiteMessageException;
import fr.paris.lutece.portal.web.LocalVariables;
import java.sql.Date;
import fr.paris.lutece.util.date.DateUtil;
import fr.paris.lutece.portal.web.l10n.LocaleService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import java.util.ArrayList;
import org.apache.commons.fileupload.FileItem;
import fr.paris.lutece.portal.business.file.File;
import fr.paris.lutece.portal.web.upload.MultipartHttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import fr.paris.lutece.plugins.project.business.Project;
import fr.paris.lutece.plugins.project.business.ProjectHome;
/**
 * This is the business class test for the object Project
 */
public class ProjectXPageTest extends LuteceTestCase
{
    private static final int UNENTIER1 = 1;
    private static final int UNENTIER2 = 2;
    private static final String DEUXSH1 = "DeuxSh1";
    private static final String DEUXSH2 = "DeuxSh2";
    private static final String TROISMD1 = "TroisMd1";
    private static final String TROISMD2 = "TroisMd2";
    private static final String QUATRELG1 = "QuatreLg1";
    private static final String QUATRELG2 = "QuatreLg2";
	private static final String CINQMAIL1 = "cinqmail1@test.com";
    private static final String CINQMAIL2 = "cinqmail2@test.com";
	private static final String SIXURL1 = "http://sixurl1.com";
    private static final String SIXURL2 = "http://sixurl2.com";
	private static final Date SEPTDATE1 = new Date( 1000000l );
    private static final Date SEPTDATE2 = new Date( 2000000l );
	private static final boolean HUITB1 = true;
    private static final boolean HUITB2 = false;
	private static final File NEUFFILE1 = new File( );
    private static final File NEUFFILE2 = new File( );

public void testXPage(  ) throws AccessDeniedException, IOException
	{
        // Xpage create test
        MockHttpServletRequest request = new MockHttpServletRequest( );
		MockHttpServletResponse response = new MockHttpServletResponse( );
		MockServletConfig config = new MockServletConfig( );

		ProjectXPage xpage = new ProjectXPage( );
		assertNotNull( xpage.getCreateProject( request ) );
		
		request = new MockHttpServletRequest();
		request.addParameter( "token", SecurityTokenService.getInstance( ).getToken( request, "createProject" ));
		
		LocalVariables.setLocal(config, request, response);
		
		Map<String, String [ ]> parameters = new HashMap<>( );
        parameters.put( "token", new String [ ] {
        		SecurityTokenService.getInstance( ).getToken( request, "createProject" )
        } );
        parameters.put( "action", new String [ ] {
        		"createProject"
        } );
        parameters.put( "un_entier", new String [ ] {
        String.valueOf( UNENTIER1)
        } );
        parameters.put( "deux_sh", new String [ ] {
        DEUXSH1
        } );
        parameters.put( "trois_md", new String [ ] {
        TROISMD1
        } );
        parameters.put( "quatre_lg", new String [ ] {
        QUATRELG1
        } );
        parameters.put( "cinq_mail", new String [ ] {
        CINQMAIL1
        } );
        parameters.put( "six_url", new String [ ] {
        SIXURL1
        } );
        parameters.put( "sept_date", new String [ ] {
        DateUtil.getDateString( SEPTDATE1, LocaleService.getDefault( ) )
        } );
        parameters.put( "huit_b", new String [ ] {
        String.valueOf( HUITB1)
        } );
        
        Map<String, List<FileItem>> multipartFiles = new HashMap<>( );
        
        List<FileItem> items = new ArrayList<>( );
        
        FileItem neuf_file = new DiskFileItemFactory( ).createItem( "neuf_file", "text/plain", true, "neuf_file" );
        neuf_file.getOutputStream( ).write( "something".getBytes( ) );
        items.add( neuf_file );
        multipartFiles.put( "neuf_file", items );

        MultipartHttpServletRequest requestMultipart = new MultipartHttpServletRequest(request, multipartFiles, parameters);

        assertNotNull( xpage.doCreateProject( requestMultipart ) );
		
		
		//modify Project	
		List<Integer> listIds = ProjectHome.getIdProjectsList(); 

		assertTrue( !listIds.isEmpty( ) );

		request = new MockHttpServletRequest();
		request.addParameter( "id", String.valueOf( listIds.get( 0 ) ) );

		assertNotNull( xpage.getModifyProject( request ) );

		response = new MockHttpServletResponse();
		request = new MockHttpServletRequest();
		LocalVariables.setLocal(config, request, response);
		
		parameters = new HashMap<>( );
        parameters.put( "token", new String [ ] {
        		SecurityTokenService.getInstance( ).getToken( request, "modifyProject" )
        } );
        parameters.put( "id", new String [ ] {
        		String.valueOf( listIds.get( 0 ) )
        } );
        parameters.put( "un_entier", new String [ ] {
        String.valueOf( UNENTIER1)
        } );
        parameters.put( "deux_sh", new String [ ] {
        DEUXSH1
        } );
        parameters.put( "trois_md", new String [ ] {
        TROISMD1
        } );
        parameters.put( "quatre_lg", new String [ ] {
        QUATRELG1
        } );
        parameters.put( "cinq_mail", new String [ ] {
        CINQMAIL1
        } );
        parameters.put( "six_url", new String [ ] {
        SIXURL1
        } );
        parameters.put( "sept_date", new String [ ] {
        DateUtil.getDateString( SEPTDATE1, LocaleService.getDefault( ) )
        } );
        parameters.put( "huit_b", new String [ ] {
        String.valueOf( HUITB1)
        } );

        requestMultipart = new MultipartHttpServletRequest(request, new HashMap<>( ), parameters);

        assertNotNull( xpage.doModifyProject( requestMultipart ) );

		//do confirm remove Project
		request = new MockHttpServletRequest();
		request.addParameter( "action" , "confirmRemoveProject" );
		request.addParameter( "id", String.valueOf( listIds.get( 0 ) ) );
		request.addParameter( "token", SecurityTokenService.getInstance( ).getToken( request, "confirmRemoveProject" ));;
		request.setMethod("GET");

		try
		{
			xpage.getConfirmRemoveProject( request );
		}
		catch(Exception e)
		{
			assertTrue(e instanceof SiteMessageException);
		}

		//do remove Project
		response = new MockHttpServletResponse();
		request = new MockHttpServletRequest();
		LocalVariables.setLocal(config, request, response);
		request.addParameter( "action" , "removeProject" );
		request.addParameter( "token", SecurityTokenService.getInstance( ).getToken( request, "removeProject" ));
		request.addParameter( "id", String.valueOf( listIds.get( 0 ) ) );
		assertNotNull( xpage.doRemoveProject( request ) );

    }
    
}
