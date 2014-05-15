//
//  CDVCookieMonster.h
//  
//
//  Created by Barrett Cervenka on 5/15/14.
//
//

#import <Cordova/CDVPlugin.h>

@interface CDVCookieMonster : CDVPlugin

- (void)getCookieValue:(CDVInvokedUrlCommand*)command;

@end
