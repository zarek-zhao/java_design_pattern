import time

import requests
from lxml import etree

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.204 Safari/537.36',
    'Cookie': 'AD_RS_COOKIE=20080918; _trs_uv=kahvgie3_6_fc6v'
}


def province():
    response = requests.get('http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/index.html', headers=headers)
    response.encoding = 'gbk'
    text = response.text
    html = etree.HTML(text)
    trs = html.xpath('//tr[@class="provincetr"]/td')
    for tr in trs[0:31]:  # 最后一个是空值
        province = tr.xpath('./a/text()')[0]
        # print(province)
        page = tr.xpath('./a/@href')[0]
        province_url = 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/' + page
        # print(province_url)
        city(province_url, province)
        time.sleep(2)


def city(province_url, province):
    response2 = requests.get(province_url, headers=headers)
    response2.encoding = 'gbk'
    text2 = response2.text
    html2 = etree.HTML(text2)
    trs = html2.xpath('//tr[@class="citytr"]')
    for tr in trs:
        page = tr.xpath('./td[1]/a/@href')[0]
        city_url = 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/' + page
        # print(city_url)
        city_id = tr.xpath('./td[1]/a/text()')[0]
        # print(city_id)
        city = tr.xpath('./td[2]/a/text()')[0]
        # print(city)
        # fp.write('%s,%s\t,%s\n' % (city, city_id ,province))
        country(city_url, city, city_id, province, province_url)
        time.sleep(1)


def country(city_url, city, city_id, province, province_url):  # 县区级
    response3 = requests.get(city_url, headers=headers)
    response3.encoding = 'gbk'
    text3 = response3.text
    html3 = etree.HTML(text3)
    trs = html3.xpath('//tr[@class="countytr"]')
    for tr in trs:  # 福建泉州金门县有点问题
        try:
            page = tr.xpath('./td[1]/a/@href')[0]
            country_url = province_url.replace('.html', '/') + page
            country_id = tr.xpath('./td[1]/a/text()')[0]
            country = tr.xpath('./td[2]/a/text()')[0]
            print(country, country_id)
            street(country_url, country, country_id, province, province_url)

            # time.sleep(0.5)

        except:
            pass


def street(country_url, country, country_id, province, province_url):  # 街道级
    response4 = requests.get(country_url, headers=headers)
    response4.encoding = 'gbk'
    text4 = response4.text
    html4 = etree.HTML(text4)
    trs = html4.xpath('//tr[@class="towntr"]')
    for tr in trs:  # 福建泉州金门县有点问题
        try:
            # page = tr.xpath('./td[1]/a/@href')[0]
            # country_url = province_url.replace('.html','/') + page
            street_id = tr.xpath('./td[1]/a/text()')[0]
            street = tr.xpath('./td[2]/a/text()')[0]
            print(street, street_id)
            fp.write('%s,%s\t,%s,%s\t,%s,%s\t,%s\n' % (
                street, street_id, country, country_id, country, country_id, province))
            # time.sleep(0.5)
        except:
            pass


if __name__ == '__main__':
    fp = open(r'D:\行政区划（县区）.csv', 'a')
    fp.write('%s,%s,%s,%s,%s,%s,%s\n' % ('街道', '区划代码', '县区', '区划代码', '城市', '区划代码', '省份'))  # 表头
    province()
    fp.close()
